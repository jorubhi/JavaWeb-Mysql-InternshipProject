

let validationButton=document.querySelector("#btn12");

validationButton.addEventListener('click', function(e){

{
	   

		let quantityField=document.querySelector("#quantity");
		
		let fieldMessageText=document.getElementById("errorText");
			let quantity=quantityField.value;
			
			if(!quantity) { 
				e.preventDefault();
				quantityField.style.border="2px solid red";
				quantityField.focus();
				
				fieldMessageText.innerHTML="Please enter the value";
			}
		
		else {
			quantityField.style.border="";
			
			fieldMessageText.innerHTML="";
			var num1 = parseInt(document.getElementById("quantity").value);
			if(num1<=0) {e.preventDefault();
				fieldMessageText.innerHTML="Please enter the quantity > 0";
				quantityField.focus();
			}
			
		}
		
	
		let traderField=document.querySelector("#trader");
		var traderValue=traderField.options[traderField.selectedIndex].text;
		if(traderValue == "--Select--"){
			traderField.style.border= "1px solid red";
			traderField.focus();
	}
	else {
		traderField.style.border="";
		
	}
		
		
		let sideField=document.querySelector("#sideV");
		let sideValue=sideField.options[sideField.selectedIndex].text;
		if(sideValue == "--Choose--"){e.preventDefault();
			sideField.style.border= "1px solid red";
				sideField.focus();
		}
		else {
			sideField.style.border="";
			
		}
		
		let symbolField=document.querySelector("#tickerV");
		let symbol=symbolField.options[symbolField.selectedIndex].text;
		if(symbol == "--Select--"){ e.preventDefault();
			symbolField.style.border= "1px solid red";
				symbolField.focus();
		}
		else {
			symbolField.style.border="";
			
		}

}
});