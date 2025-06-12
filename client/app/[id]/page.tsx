'use client';
import { useParams } from 'next/navigation';

export default function Home() {
  const { id } = useParams();
  return <main>{id}</main>;
}
