'use client';
import { useParams, useRouter } from 'next/navigation';
import { useState, useRef } from 'react';
import axios from 'axios';

export default function CreatePage() {
  const { id } = useParams();
  const router = useRouter();
  const [noteName, setNoteName] = useState<string>('');
  const [noteDescription, setNoteDescription] = useState<string>('');
  const createButtonRef = useRef<HTMLDivElement>(null);

  const handleNoteNameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setNoteName(event.target.value);
  };

  const handleNoteDescriptionChange = (
    event: React.ChangeEvent<HTMLInputElement>,
  ) => {
    setNoteDescription(event.target.value);
  };

  const handleKeyDown = (event: React.KeyboardEvent<HTMLInputElement>) => {
    if (event.key === 'Enter') {
      createButtonRef.current?.click();
    }
  };

  const handleCreatePage = () => {
    if (!noteName || !noteDescription) {
      alert('노트 이름과 설명을 입력해주세요.');
      return;
    }
    axios
      .post(`/api/notes`, {
        slug: id,
        name: noteName,
        description: noteDescription,
      })
      .then((response) => {
        if (response.status === 200) {
          router.replace(`/${id}`);
        } else {
          // console.error('페이지 생성 실패:', response.data);
        }
      })
      .catch((error) => {
        // console.error('페이지 생성 중 오류 발생:', error);
      });
  };

  return (
    <div className="mx-auto w-[90%] max-w-[800px] py-60">
      <h1 className="font-semibold">NoteSpace Not Found</h1>
      <div>새 노트를 생성하시겠습니까?</div>
      <div className="my-4 flex flex-col gap-2">
        <input
          className="w-[200px] rounded-lg border-1 border-solid p-2 focus:outline-none"
          placeholder="노트 이름"
          value={noteName}
          onChange={handleNoteNameChange}
          onKeyDown={handleKeyDown}
        ></input>
        <input
          className="w-[200px] rounded-lg border-1 border-solid p-2 focus:outline-none"
          placeholder="노트 설명"
          value={noteDescription}
          onChange={handleNoteDescriptionChange}
          onKeyDown={handleKeyDown}
        ></input>
      </div>
      <div className="mt-8 flex justify-end">
        <div
          ref={createButtonRef}
          className="inline-block cursor-pointer rounded-2xl bg-blue-500 px-6 py-4 text-white"
          onClick={handleCreatePage}
          tabIndex={0}
        >
          생성
        </div>
      </div>
    </div>
  );
}
