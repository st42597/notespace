'use client';
import { useState, useRef } from 'react';
import { useRouter } from 'next/navigation';

export default function Home() {
  const router = useRouter();
  const [searchUrl, setSearchUrl] = useState<string>('');
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

  return (
    <div className="flex h-screen flex-col items-center justify-center">
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
  );
}
