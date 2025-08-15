'use client';
import { useState, useEffect, useRef } from 'react';
import { useRouter } from 'next/navigation';
import { Note } from '@/types/note';
import axios from 'axios';
import RecentNoteList from './_components/RecentNoteList';

export default function Home() {
  const router = useRouter();
  const [searchUrl, setSearchUrl] = useState<string>('');
  const [recentUpdatedNotes, setRecentUpdatedNotes] = useState<Note[]>([]);
  const searchButtonRef = useRef<HTMLDivElement>(null);

  const handleSearchUrlChange = (
    event: React.ChangeEvent<HTMLInputElement>,
  ) => {
    setSearchUrl(event.target.value);
  };

  const handleSearch = () => {
    if (searchUrl) {
      router.push(`/${searchUrl}`);
    }
  };

  const handleKeyDown = (event: React.KeyboardEvent<HTMLInputElement>) => {
    if (event.key === 'Enter') {
      searchButtonRef.current?.click();
    }
  };

  useEffect(() => {
    const fetchNoteList = async () => {
      try {
        const response = await axios.get('/api/notes/recent-updated', {
          params: {
            limit: 5,
          },
        });
        setRecentUpdatedNotes(response.data);
      } catch (error) {
        console.error('노트 목록을 가져오는 중 오류 발생:', error);
      }
    };

    fetchNoteList();
  }, []);

  return (
    <div className="flex h-screen flex-col items-center justify-center gap-8">
      <div className="flex flex-col items-center justify-center">
        <h1 className="font-semibold">NoteSpace</h1>
        <div className="radius-lg flex items-center justify-between border-2 border-solid">
          <input
            className="rounded-lg p-4 focus:outline-none"
            value={searchUrl}
            onChange={handleSearchUrlChange}
            onKeyDown={handleKeyDown}
          ></input>
          <div
            ref={searchButtonRef}
            className="cursor-pointer border-l-2 p-4"
            onClick={handleSearch}
            tabIndex={0}
          >
            검색
          </div>
        </div>
      </div>
      <div>
        <span className="text-xl">Recently Updated Notes</span>
        <RecentNoteList data={recentUpdatedNotes} />
      </div>
    </div>
  );
}
