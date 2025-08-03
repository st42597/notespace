import CreateNote from '@/components/CreateNote';

export default function CreatePage({ params }: { params: { id: string } }) {
  return <CreateNote slug={params.id} />;
}
