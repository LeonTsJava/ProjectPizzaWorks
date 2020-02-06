//=====畫面相關=====
//出現聊天視窗
//顧客送訊息來才會出現
function openCSbox(Email,Name){
	if(document.getElementById("cs_"+Email+"block")==undefined){
		$(".cs_MessageContent").append("<li><a href='#cs_"+Email+"block' id='"+Email+"'>" +
				"<p>"+Name+"</p></li>");
		$("#tabs").append("<div id='cs_"+Email+"block'></div>");
	}else{

	}
	return document.getElementById("cs_"+Email+"block");
}
//收到顧客訊息
function getCustomerMessage(messageOutput){
	var responseCS=openCSbox(messageOutput.message.from,messageOutput.message.fromName);
	var pCS = document.createElement('p');
    pCS.appendChild(document.createTextNode(messageOutput.message.text)); 
    var divCS=document.createElement('div');
    divCS.setAttribute("class","cs_comeMessage"); 
    divCS.appendChild(pCS);
    responseCS.appendChild(divCS);

    responseCS.scrollTop = responseCS.scrollHeight;
}
//發出訊息(需要包進this)
function sendToCustomerMessage(obj){
	var textToCustomer = $(obj).parent().children(".customerService_input").val();
    console.log(textToCustomer);
    
    var To=document.getElementsByClassName("sel")[0].id;
    console.log(To);
    if(textToCustomer != ''){
        stompClient.send("/app/customerchat/"+To, {}, JSON.stringify({'from':userName, 'text':textToCustomer}));
        console.log($(".stContainer").children("#cs_"+To+"block"));
        $(".stContainer").children("#cs_"+To+"block").append("<div class='cs_myMessage'><p>"+textToCustomer+"</p></div>");
    }
    $(obj).parent().children(".customerService_input").val("");
}

//按下enter會送出
function CsputEnter(obj){
	var textToCustomer = $(obj).val();
	var To=document.getElementsByClassName("sel")[0].id;
	if(event.keyCode==13 && textToCustomer!='\n'){
		sendToCustomerMessage(email,obj);
	}
	//如果只有按下enter會清掉
	if(textToCustomer=='\n'){
		$(obj).val("");
	}
}




//=====WebSocket=====


