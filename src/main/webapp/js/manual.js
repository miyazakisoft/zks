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

var numberselect = function(){

  location.href = './numberselect.html?group_id='
  + getParam('group_id')
  + '&access_token='
  + getParam('access_token')
  + "&pj_id="
  + getParam('pj_id');
}

$('#numberselect_button').click(numberselect);
