import Link from 'next/link';

export default function Header() {
  return (
    <header className="flex h-[50px] items-center justify-between px-6 py-2">
      <div className="flex items-center gap-6">
        <Link href="/" className="text-xl">
          NoteSpace
        </Link>
        <Link href="/discover/guide">Guide</Link>
      </div>
      <div className="flex items-center gap-6">
        <Link href="/discover/create">Create</Link>
        <Link href="/discover/note">Note</Link>
        <Link href="/discover/random">Random</Link>
      </div>
    </header>
  );
}
