'use client';
import { useParams, redirect } from 'next/navigation';

export default function NotePage() {
  const { id } = useParams();
  // 데이터가 없으면 redirect
  redirect(`/create/${id}`);

  return <main>{id}</main>;
}
