### 📌 Spring Boot + Thymeleaf

- MVC 구조로 예약 페이지, 관리자 페이지 구성
- Thymeleaf로 달력/시간대 UI 구현

### 📌 PostgreSQL

- 테이블 설계 예시
    - **User** (id, name, email, role)
    - **Store** (id, name, location, open_time, close_time)
    - **Reservation** (id, user_id, store_id, time_slot, status)
- **동시성 제어**: 동일 시간대에 1명만 예약되도록
    - DB Unique Index (store_id + time_slot)
    - Transaction & Isolation Level (예: SERIALIZABLE or OPTIMISTIC LOCK)

### 📌 WebSocket

- 예약 현황이 바뀌면 대기 중인 모든 클라이언트에게 push
- 예: “19:00 예약 완료됨” → 다른 사용자 화면에 바로 반영

### 📌 Docker

- 앱 서버(Spring Boot), DB(PostgreSQL) 각각 컨테이너화
- `docker-compose.yml`로 로컬 개발 환경 구성

### 📌 AWS

- EC2: 애플리케이션 서버 배포
- RDS: PostgreSQL 운영 DB
- (옵션) S3: 매장 이미지 업로드
- (옵션) CloudWatch: 서버 모니터링
