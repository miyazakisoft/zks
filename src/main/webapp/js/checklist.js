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

function check_button_click(){
  var n = 5;
  var number_list = ["5001","5002","5003","5004","5005"];

  for(let l=0; l<number_list.length; l++){
    for(i=1;i<=n;i++){
      var cn = i;
      if(i<10){
        cn = "0" + String(i)
      }
      document.getElementById("CN" + cn + "-" + number_list[l] + "-C2").disabled = true;
    }
  }
}

function checkbox_click(check_id){
  if(check_id.match(/C1/)){
    target_form = check_id.replace("-C1","") + "-C2";
    console.log(target_form);
    document.getElementById(target_form).disabled = false;
  }
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
