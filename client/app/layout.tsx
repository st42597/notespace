import type { Metadata } from 'next';
import './globals.css';
import './reset.css';

export const metadata: Metadata = {
  title: 'NoteSpace',
  description: 'take notespace',
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html>
      <body>{children}</body>
    </html>
  );
}
