'use client';
import Header from './_components/Header';
import { useParams, useRouter } from 'next/navigation';
import { useState, useEffect, useRef } from 'react';
import axios, { AxiosError } from 'axios';

export default function NotePage() {
  const { id } = useParams();
  const router = useRouter();
  const intervalRef = useRef<ReturnType<typeof setInterval> | null>(null);
  const [noteName, setNoteName] = useState<string>('');
  const [noteDescription, setNoteDescription] = useState<string>('');
  const [markdownContent, setMarkdownContent] = useState<string>('');
  const [isRecentlyTyped, setIsRecentlyTyped] = useState<boolean>(false);
  const isRecentlyTypedRef = useRef(isRecentlyTyped);
  const markdownContentRef = useRef(markdownContent);

  const handleMarkdownChange = (
    event: React.ChangeEvent<HTMLTextAreaElement>,
  ) => {
    setMarkdownContent(event.target.value);
    setIsRecentlyTyped(true);
  };

  const handleFocus = () => {
    if (intervalRef.current) return;
    intervalRef.current = setInterval(() => {
      if (!isRecentlyTypedRef.current) return;
      setIsRecentlyTyped(false);
      axios.patch(`/api/notes/${id}/markdown`, {
        content: markdownContentRef.current,
      });
    }, 1000);
  };

  const handleBlur = () => {
    if (intervalRef.current) {
      clearInterval(intervalRef.current);
      intervalRef.current = null;
    }
  };

  useEffect(() => {
    isRecentlyTypedRef.current = isRecentlyTyped;
  }, [isRecentlyTyped]);

  useEffect(() => {
    markdownContentRef.current = markdownContent;
  }, [markdownContent]);

  useEffect(() => {
    const fetchNote = async () => {
      try {
        const response = await axios.get(`/api/notes/${id}`);
        const { name, description } = response.data;
        setNoteName(name);
        setNoteDescription(description);
      } catch (error) {
        const err = error as AxiosError;
        if (err.response?.status === 404) {
          // note가 없으면 redirect
          router.replace(`/create/${id}`);
        }
        console.error('노트 데이터를 가져오는 중 오류 발생:', error);
      }
    };
    const fetchMarkdown = async () => {
      try {
        if (isRecentlyTypedRef.current) return;
        const response = await axios.get(`/api/notes/${id}/markdown`);
        const { content } = response.data;
        setMarkdownContent(content);
      } catch (error) {
        console.error('마크다운 데이터를 가져오는 중 오류 발생:', error);
      }
    };

    fetchNote();
    fetchMarkdown();

    const intervalId = setInterval(fetchMarkdown, 1000);

    return () => clearInterval(intervalId);
  }, []);

  if (!noteName || !noteDescription) {
    return <main></main>;
  }

  return (
    <>
      <Header name={noteName} description={noteDescription} />
      <main>
        <div className="mx-auto max-w-[800px]">
          <h1>Markdown</h1>
          <textarea
            className="h-[400px] w-[600px] resize-none border-1 border-solid p-2 focus:outline-none"
            value={markdownContent}
            onChange={handleMarkdownChange}
            onFocus={handleFocus}
            onBlur={handleBlur}
          ></textarea>
        </div>
      </main>
    </>
  );
}
