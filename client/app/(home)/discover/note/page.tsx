'use client';
import { useState, useEffect } from 'react';
import { Note } from '@/types/note';
import RecentNoteList from '../../_components/RecentNoteList';

export default function NotePage() {
  const [recentUpdatedNotes, setRecentUpdatedNotes] = useState<Note[]>([]);
  const [recentCreatedNotes, setRecentCreatedNotes] = useState<Note[]>([]);

  useEffect(() => {
    const fetchUpdatedNotes = async () => {
      const response = await fetch('/api/notes/recent-updated');
      const data = await response.json();
      setRecentUpdatedNotes(data);
    };

    const fetchCreatedNotes = async () => {
      const response = await fetch('/api/notes/recent-created');
      const data = await response.json();
      setRecentCreatedNotes(data);
    };

    fetchUpdatedNotes();
    fetchCreatedNotes();
  }, []);

  return (
    <div className="flex">
      <div>
        <span>Recently Updated Notes</span>
        <RecentNoteList data={recentUpdatedNotes} />
      </div>
      <div>
        <span>Recently Created Notes</span>
        <RecentNoteList data={recentCreatedNotes} />
      </div>
    </div>
  );
}
