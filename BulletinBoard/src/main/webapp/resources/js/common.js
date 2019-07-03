/**
 * 
 */

  
/**
 * 
 */
function removeEmptyOnForm(name){
	  
  var children = $(name).children('input');
	  
  children.each(function(){
	  if(!$(this).val()){
		  $(this).remove();
	  }
  });
	  
}