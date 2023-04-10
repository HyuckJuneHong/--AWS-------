/** 변수의 속성으로 function을 추가한 이유
 *
 * 브라우저의 scope는 공용 공간으로 쓰이기 때문에 나중에 로딩된 js의 init, save가 먼저 로딩된 js의 function을 덮어쓰게 된다.
 * 여러 사람이 참여하는 프로젝트에서는 중복된 function 이름은 자주 발생할 수 있다.
 * 물론, 모든 function 이름을 확인하면서 만들 수는 없다.
 * 그러다 보니 이런 문제를 피하려고 main.js 만의 유효 scope를 만들어 사용한다.
 *
 * 즉, var main 객체를 만들어 해당 객체에서 필요한 모든 function을 선언.
 * 이는 main 객체 안에서만 function이 유효하기 때문에 다른 JS와 겹칠 위험이 사라진다.
 */
var main = {

    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.savePost();
        });
    },

    savePost : function () {

        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)

        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';

        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();