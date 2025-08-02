export default function NoteHeader(props: {
  name: string;
  description: string;
}) {
  return (
    <header>
      <div className="flex h-8 items-center px-6">
        <div className="flex items-center gap-2">
          <span>{props.name}</span>
          <span>/</span>
          <span>{props.description}</span>
        </div>
      </div>
    </header>
  );
}
