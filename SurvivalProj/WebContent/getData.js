/**
 * 
 */
let productForm = document.querySelector("#product-form");
let showBtn = document.querySelector(".btn-success");
let hideBtn = document.querySelector(".btn-danger");



showBtn.addEventListener("click", function(e) {
	productForm.style.display = "block";
})

hideBtn.addEventListener("click", function(e) {
	productForm.style.display = "none";
})