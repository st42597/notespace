'use client';
import { useRouter } from 'next/navigation';
import { useEffect } from 'react';

export default function Create() {
  const router = useRouter();
  useEffect(() => {
    router.replace('/create');
  }, []);
  return <div></div>;
}
