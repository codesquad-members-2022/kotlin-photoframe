# step1
## 결과
<img width="1261" alt="스크린샷 2022-02-14 오후 12 23 31" src="https://user-images.githubusercontent.com/79190824/153797452-6bdbf9c9-cf18-4f54-b8e7-851c220121dd.png">

## Activity

- Lifecycle은 무엇인가?
- 사용자가 앱을 이용할때 일어나는 앱을 탐색 하거나 정지 등을 해서 변화가 일어날때 상태 변화를 알려주는 것

- Lifecycle이 변경되었음은 어떻게 알 수 있는가?
사용자의 반응에 따라 Activity가 첫 시작할때, 다시 시작할때, 화면에 나올때 포커스를 잃을때, 정지할때, 없어 질때 각각 onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy()가 호출되면서 Lifecycle의 변경을 알린다.