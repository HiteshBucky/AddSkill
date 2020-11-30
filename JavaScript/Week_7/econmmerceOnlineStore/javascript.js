  var fruits_list = ["Strawberry's", "Mango's", "Pineapple's"];
  var vegetables_list = ["Cucumber", "Tomatoes", "Chilli's"];
  var cartList = [];
  var searchList = [];


  /*  Email validation */
  email.onblur = function() {
      if (!this.value.includes('@')) { // not email
          this.classList.add("invalid");
          input.focus();
      } else {
          this.classList.remove("invalid");
      }
  }

  /*  Filter property function  */
  function myFunction() {

      var filter = myInput.value.toUpperCase();
      searchList.push(filter);
      console.log(searchList)

      var totoal_row = document.getElementsByClassName('row');

      for (let i = 0; i < totoal_row.length; i++) {
          let curr_row = totoal_row[i];
          for (let j = 0; j < curr_row.children.length; j++) {
              var curr_heading = curr_row.children[j].getElementsByClassName('panel-heading')[0].innerText;

              if (curr_heading.toUpperCase().indexOf(filter) > -1) {
                  curr_row.children[j].style.display = "";
              } else {
                  curr_row.children[j].style.display = "none";
              }
          }
      }
  } 

  /*  Added Dropdown functionality*/
  function dropdownFunction(event) {
      var isFruit = event.value == 'Fruits'

      var totoal_row = document.getElementsByClassName('row');

      for (let i = 0; i < totoal_row.length; i++) {
          let curr_row = totoal_row[i];
          for (let j = 0; j < curr_row.children.length; j++) {
              var curr_heading = curr_row.children[j].getElementsByClassName('panel-heading')[0].innerText;
              console.log(curr_heading)

              // Checking for fruits
              if (event.value == 'Fruits') {
                  if (fruits_list.includes(curr_heading))
                      curr_row.children[j].style.display = "";
                  else
                      curr_row.children[j].style.display = "none";
              }
              // Checking for Vegetables
              else if (event.value == 'Vegetables') {
                  if (vegetables_list.includes(curr_heading))
                      curr_row.children[j].style.display = "";
                  else
                      curr_row.children[j].style.display = "none";
              }
              // Rendering everything
              else curr_row.children[j].style.display = "";
          }
      }
  }




  /*  Redirect to more details */
  function moreDetails(event) {

      var parentNode = event.parentNode;
      var name = parentNode.children[0].innerText;
      var imageUrl = parentNode.children[1].children[0].src;

      var queryString = "?name=" + name + "&imageUrl=" + imageUrl;
      window.location.href = "details.html" + queryString;
  }



  /*  Add item into the cart*/
  function add_Cart(event) {
      var heading = event.parentNode.parentNode.children[0].innerText;
      cartList.push(heading);
  }



  /* Show cart*/
  function showCart() {
      var queryString = "?cart=" + cartList;
      window.location.href = "cart.html" + queryString;
  }


 /* Calculating time in each div*/
 
  var start = ''; var end = '';

  function onHover(id){
        start=new Date()
  };
    
  function onHoverout(id){
      final=new Date()
      console.log(((final.getTime()-start.getTime())/1000)+" secs in " + id);
  };

