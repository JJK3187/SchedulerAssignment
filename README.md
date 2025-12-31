## 1. 일정 관리 앱 만들기
Spring을 이용해여 3 Layer Architechure에 따라서 개발한 일정 관리 앱
CRUD 기능을 구현했다.
## 2. 기능
-  **일정생성** :  일정 제목, 내용, 작성자, 비밀번호를 작성하여 일정을 생성한다.
- **전체조회** : 생성된 일정을 작성자명 기준으로 조회한다(작성자명이 없을 시 모든 일정 조회)
- **선택조회** : 고유 식별자로 선택한 일정 조회                                      
- **일정수정** : 고유 식별자 및 비밀번호를 통해 식별한 일정의 제목, 작성자명을 수정 할 수 있다.
- **일정삭제** : 고유 식별자 및 비밀번호를 통해 식별한 일정을 삭제한다.
- 비밀번호가 필요한 경우 비밀번호가 틀릴 시 경고 문구 출력
## 3. API 명세서
<a href="https://documenter.getpostman.com/view/50328965/2sBXVbJtrb" target="_blank">API명세서 링크(PostMan)</a>
## 4. ERD
<img width="830" height="850" alt="schedulers" src="https://github.com/user-attachments/assets/d12d0ff7-c820-43c8-b828-1b6c96c98da8" />

