window.addEventListener("load", function(){
		var input=document.querySelector("input[name=memberNick]");
		input.addEventListener("input", function(){
			var regex=/^[가-힣]{2,10}$/;
			this.classList.remove("correct","incorrect");
			if(this.value){
				if(regex.test(this.value)){
					this.classList.add("correct");
				}else{
					this.classList.add("incorrect");
				}
			}
		});
	});