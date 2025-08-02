'use client';
import axios from 'axios';
import { useEffect } from 'react';
import { useRouter } from 'next/navigation';

export default function Random() {
  const router = useRouter();

  useEffect(() => {
    const fetchRandomNote = async () => {
      try {
        const response = await axios.get('/api/notes/random');
        router.replace(`/${response.data.slug}`);
      } catch (error) {
        console.error('Error fetching random note:', error);
      }
    };
    fetchRandomNote();
  }, []);

  return (
    <div>
      <h1>Random Page</h1>
    </div>
  );
}
