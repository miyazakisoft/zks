/**
* Get the URL parameter value
*
* @param  name {string} パラメータのキー文字列
* @return  url {url} 対象のURL文字列（任意）
*/
function getParam(name, url) {
  if (!url) url = window.location.href;
  name = name.replace(/[\[\]]/g, "\\$&");
  var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
    results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

//var url = window.location.host;
var listselect = function(){
  location.href = './listselect.html?group_id=' + getParam('group_id') + '&access_token=' + getParam('access_token');
}

function check_button_click(){
  console.log("aa");
}

$('#listselect_button').click(listselect);
