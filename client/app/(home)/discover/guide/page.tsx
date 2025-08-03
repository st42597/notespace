export default function Guide() {
  return (
    <div className="mx-auto w-[90%a] max-w-[800px] py-[60px]">
      <h1 className="mb-4 text-2xl font-bold">NoteSpace 사용법</h1>
      <section className="mb-6">
        <h2 className="mb-2 text-xl font-semibold">🚀 NoteSpace란?</h2>
        <ul className="ml-5 list-disc">
          <li>
            NoteSpace는 <strong>Note기반의 정보 저장과 공유</strong>를 위한
            공간입니다.
          </li>
          <li>
            익명 사용자를 포함해 누구나 자유롭게 참여할 수 있는{' '}
            <strong>오픈 커뮤니티</strong>입니다.
          </li>
        </ul>
      </section>

      <section className="mb-6">
        <h2 className="mb-2 text-xl font-semibold">📝 Note란?</h2>
        <ul className="ml-5 list-disc">
          <li>
            Note는 여러 소통 방식(채팅, 댓글 등)을 모은{' '}
            <strong>Space들의 집합</strong>입니다.
          </li>
          <li>
            <strong>공유와 협업</strong>이 가능해 여러 사람이 함께 정보를
            추가하고 지식을 발전시킬 수 있습니다.
          </li>
        </ul>
      </section>

      <section className="mb-6">
        <h2 className="mb-2 text-xl font-semibold">🌱 Space란?</h2>
        <ul className="ml-5 list-disc">
          <li>
            Space는 소통을 위한 공간으로, <strong>플레인 텍스트</strong>와{' '}
            <strong>댓글</strong> 등 다양한 소통 방식을 지원합니다.
          </li>
          <li>
            기존 소통 방식을 병렬적으로 제공해 새로운 협업 경험을 만듭니다.
          </li>
        </ul>
      </section>

      <section className="mb-6">
        <h2 className="mb-2 text-xl font-semibold">🚀 노트 생성 방법</h2>
        <ul className="ml-5 list-disc">
          <li>
            우측 상단의 <strong>Create</strong> 버튼을 누르거나, 메인 페이지
            검색을 통해 새로운 노트를 생성할 수 있습니다.
          </li>
          <li>
            노트가 만들어지면 <strong>Space 기능</strong>을 활용해 다양한 정보를
            새롭게 작성할 수 있습니다.
          </li>
          <li>
            여러 사용자가 함께 정보를 추가·수정하며 노트를 발전시킬 수 있습니다.
          </li>
        </ul>
      </section>
    </div>
  );
}
