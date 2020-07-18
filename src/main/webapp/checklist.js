function check_button_click(){
  var n = 5;
  var number_list = ["5001","5002","5003","5004","5005"];

  for(let l=0; l<number_list.length; l++){
    for(i=1;i<=n;i++){
      var sn = i;
      if(i<10){
        sn = "0" + String(i)
      }
      document.getElementById("P" + sn + "-" + number_list[l] + "-C2").disabled = true;
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
