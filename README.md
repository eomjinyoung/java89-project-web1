# v0.1 : 프로젝트 만들기
## 프로젝트 폴더 구조
bitcamp-web/src/main/java       : 자바 소스 파일
                    /resources  : 실행할 때 참고할 설정 파일(.properties, .xml, .txt 등)
                    /webapp     : HTML, CSS, JavaScript, 그림 파일 등 웹 관련 파일
               /test/java       : 단위 테스트를 할 때 사용할 자바 소스 파일
                    /resources  : 단위 테스트를 실행할 때 참고할 설정 파일
## Gradle 빌드 설정 파일
bitcamp-web/build.gradle        : Gradle 빌드 도구의 설정 파일

## 이클립스 설정 파일 생성
>gradle eclipse     : Gradle 명령 실행

## 이클립스 워크스페이스로 프로젝트 로딩
File 메뉴 --> import... --> General 노드 / Existing Projects into Workspace 선택
[다음] 클릭 --> bitcamp-web 프로젝트 폴더 선택 --> [Finish] 클릭