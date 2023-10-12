# jsp-study
게시판을 JSP를 사용하여 Model 1 및 Model 2 아키텍처로 구현해보자

## Model1
비지니스 로직과 view를 JSP에서 모두 처리한다. <br>
프로젝트가 커질수록 유지 보수가 어렵다. <br>
소규모 개발에 적합하다. <br>

<img src="https://velog.velcdn.com/images%2Fchamroro%2Fpost%2Fbae34d3e-f78c-43d3-b1d6-ba87b3a7fefc%2Fimage.png" width=50% height=50% > </img>
<img src="https://velog.velcdn.com/images%2Fchamroro%2Fpost%2F113ede0d-2b0d-4a56-8ba7-c47d0275f99a%2Fimage.png" width=50% height=50% > </img>


## Model2 
model2는 MVC패턴을 웹개발에 도입한 구조이다.<br>
비지니스 로직과 view를 분리했다.<br>
프론트, 백엔드가 분리되어 분업이 용이하다. <br>

| MVC 컴포넌트    | 설명                              | JSP 모델 2에서의 역할                    |
| -------------- | --------------------------------- | ---------------------------------------- |
| Model (모델)     | 비즈니스 로직과 데이터 처리 담당    | Java 클래스, JavaBean, Service                    |
| View (뷰)       | 사용자에게 정보 표시 담당          | JSP 페이지                               |
| Controller (컨트롤러) | 클라이언트 요청 관리 및 조정   | 서블릿(Servlet)                         |


<img src="https://velog.velcdn.com/images%2Fchamroro%2Fpost%2F04b0331e-d7cf-4a0b-b154-ec0d06f956e9%2Fimage.png" width=50% height=50% > </img>
<img src="https://velog.velcdn.com/images%2Fchamroro%2Fpost%2F361d0959-2e73-49ae-9685-fa9f8ed355a6%2Fimage.png" width=50% height=50% > </img>



ref <br>
https://velog.io/@chamroro/JSP-Model1-Model2-Spring-MVC-pattern-%EC%B0%A8%EC%9D%B4
