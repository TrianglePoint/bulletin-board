# bulletin-board
bulletin board project.

# requirements
 - client can check the all post.
 - client can check the one post.
 - client can create the post.
 - client can modify the post.
 - client can delete the post.
* * *
 - 고객은 전체 게시물을 조회할 수 있다.
 - 고객은 하나의 게시물을 조회할 수 있다.
 - 고객은 게시물을 작성할 수 있다.
 - 고객은 게시물을 수정할 수 있다.
 - 고객은 게시물을 삭제할 수 있다.
* * *
 - 客は全体の掲示物が照会できる。
 - 客は一つの掲示物が照会できる。
 - 客は掲示物が作成できる。
 - 客は掲示物が修正できる。
 - 客は掲示物が削除できる。
 
# design
## package
 - org.trianglepoint.post.controller (controller of MVC2)
 - org.trianglepoint.post.domain (store the data that receive from DB)
 - org.trianglepoint.post.mapper (connect to DB as mybatis)
 - org.trianglepoint.post.service (business logic)
