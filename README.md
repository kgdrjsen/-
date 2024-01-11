# -
일단 올리는 연습중.

깃 허브에 프로젝트를 폴더별로 올리기 위해 할 것.

1 . D드라이브에 있는 폴더가 깃허브 AndroidStudy 레포지토리에 넣을 디렉토리이므로
   올릴 프로젝트 파일을 복사해서 넣는다.

2 . 폴더로 넣을 텐데 이 때 깃 폴더가 AndroidStudy라는 최상위 폴더에만 존재해야 하고
   그 밑에 들어가 하위 폴더에는 있으면 안 된다.

2-1 . 깃 폴더가 있어서 오류가 터미널에 뜰 경우 ->
warning : in th working copy of ' ... / settings.gradle.kts', LF will be replaced by CRLF
the next time Git touches it
대충 마지막에 Git touches it으로 끝나는 말이 있으면 깃 폴더든 깃 파일이든 있다는 소리이니
추가한 폴더에 'cd 추가한폴더' 로 들어가서 그안에 'rm -rf .git' 이라는 코드를 입력하면 된다.
그리고 나서 다시 나와서 git add . 하면 됨.

2-2 . 만약에 위에서 깃폴더/파일을 삭제해도 안된다면 CRLF를 LF와 변환해줘야 한다는데
그냥 이 프로젝트만 하려면 'git config core.autocrlf true' 를 입력하고 (그 폴더에 들어가서)
여러 폴더를 올릴거면 'git config --global core.autocrlf true' 를 상위 폴더에서 그냥 입력
후 git add . 하면 됨.

2-3 . 에러 bad boolean config value 'true' for 'core.autocrlf' 는 2-2의 코드를 잘못
적어서 일어난 일이니 2-2를 다시 하기.

3 . 에러 src refspec main does not match any 해결방법 -> 아마 로컬인 master 브랜치로
떠서 원격 브랜치에 푸시를 못하는 경우
이때 강제로 'git push -u origin +main' 을 하는 방법도 있는 데 이는 로컬에 없고 원격에
있는 자료가 날라갈 수 있다.
그래서 git branch로 확인 해보고 main이 없으면 'git branch -m master main' 을 쳐서
원격에 있는 메인 브랜치로 바꿔준다.