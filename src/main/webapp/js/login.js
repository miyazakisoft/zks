var access_token = 123;
var group_id = "shikoku"

//var url = window.location.host;
var checkPassword = function(){
  location.href = './listselect.html?group_id=' + group_id + '&access_token=' + access_token;
  //console.log(url);
	//console.log("pushed");
}

$('#login_btn').click(checkPassword);
