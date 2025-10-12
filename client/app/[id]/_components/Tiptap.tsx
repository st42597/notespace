'use client';

import { useEditor, EditorContent } from '@tiptap/react';
import StarterKit from '@tiptap/starter-kit';
import { useEffect } from 'react';

interface TiptapProps {
  value: string;
  onChange: (value: string) => void;
  onFocus?: () => void;
  onBlur?: () => void;
}

export default function Tiptap({
  value,
  onChange,
  onFocus,
  onBlur,
}: TiptapProps) {
  const editor = useEditor({
    extensions: [StarterKit],
    content: value || '<p></p>',
    immediatelyRender: false, // Don't render immediately on the server to avoid SSR issues

    onUpdate: ({ editor }) => {
      onChange(editor.getHTML());
    },
    onFocus: () => {
      if (onFocus) {
        onFocus();
      }
    },
    onBlur: () => {
      if (onBlur) {
        onBlur();
      }
    },
  });

  useEffect(() => {
    if (editor && editor.getHTML() !== value) {
      editor.commands.setContent(value);
    }
  }, [value]);

  return <EditorContent editor={editor} />;
}
