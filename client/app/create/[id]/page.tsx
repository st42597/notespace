'use client';
import { useParams, redirect } from 'next/navigation';
import axios from 'axios';

export default function CreatePage() {
  const { id } = useParams();

  const handleCreatePage = () => {
    axios
      .post(`/api/notes/${id}`)
      .then((response) => {
        if (response.status === 200) {
          redirect(`/${id}`);
        } else {
          console.error('페이지 생성 실패:', response.data);
        }
      })
      .catch((error) => {
        console.error('페이지 생성 중 오류 발생:', error);
      });
  };

  return (
    <div className="mx-auto w-[90%] max-w-[800px] py-60">
      <h1 className="font-semibold">NoteSpace Not Found</h1>
      <div>새 페이지를 생성하시겠습니까?</div>
      <div className="mt-16 flex justify-end">
        <div
          className="inline-block cursor-pointer rounded-2xl bg-blue-500 px-6 py-4 text-white"
          onClick={handleCreatePage}
        >
          생성
        </div>
      </div>
    </div>
  );
}
