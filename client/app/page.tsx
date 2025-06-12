export default function Home() {
  return (
    <div className="flex h-screen flex-col items-center justify-center">
      <h1 className="font-semibold">NoteSpace</h1>
      <div className="radius-lg flex items-center justify-between border-2 border-solid">
        <input className="rounded-lg p-2 focus:outline-none"></input>
        <div className="ml-4 cursor-pointer border-l-2 p-4">검색</div>
      </div>
    </div>
  );
}
