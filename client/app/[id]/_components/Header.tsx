export default function Header(props: { name: string; description: string }) {
  return (
    <header>
      <div className="flex h-10 items-center px-4">
        <div className="flex items-center gap-2">
          <span>{props.name}</span>
          <span>/</span>
          <span>{props.description}</span>
        </div>
      </div>
    </header>
  );
}
