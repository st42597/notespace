import { Note } from '@/types/note';
import Link from 'next/link';

interface RecentNoteListProps {
  data: Note[];
}

export default function RecentNoteList({ data }: RecentNoteListProps) {
  return (
    <div className="mt-4 flex flex-col items-center justify-center gap-4">
      {data.map((note) => (
        <div
          key={note.slug}
          className="w-full bg-white p-2 transition-colors duration-200 hover:bg-gray-200"
        >
          <Link
            href={`/${note.slug}`}
            className="flex cursor-pointer flex-row items-center gap-4"
          >
            <div className="flex w-[140px] flex-col">
              <strong>{note.slug}</strong>
              <p>{note.name}</p>
            </div>
            <p>{note.description}</p>
          </Link>
        </div>
      ))}
    </div>
  );
}
