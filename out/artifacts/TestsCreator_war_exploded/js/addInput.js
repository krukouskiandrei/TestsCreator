function addCAnswer(){//добавить поле для ввода правильного ответа
    var thisElement = document.querySelector('#addCorrectAnswer');
    var theInput = document.createElement('input');
    theInput.type = 'text';
    theInput.autocomplete = 'off';
    theInput.setAttribute('name', 'correct_answer');
    thisElement.parentNode.insertBefore(theInput, thisElement.previousSibling);
}
function createQ(){//создать еще один вопрос
    var thisElement = document.querySelector('#createQuestion');
    var theInput = document.createElement('input');
    theInput.type = 'hidden';
    theInput.setAttribute('name', 'command');
    theInput.setAttribute('value', 'createQuestion');
    thisElement.parentNode.insertBefore(theInput, thisElement.parentNode.firstChild);
}
function createATest(){//создать тест
    var thisElement = document.querySelector('#createAllTest');
    var theInput = document.createElement('input');
    theInput.type = 'hidden';
    theInput.setAttribute('name', 'command');
    theInput.setAttribute('value', 'createAllTest');
    thisElement.parentNode.insertBefore(theInput, thisElement.parentNode.firstChild);
}
function addA(){//добавить поле для ввода варианта ответа
    var thisElement = document.querySelector('#addAnswer');
    var theInput = document.createElement('input');
    theInput.type = 'text';
    theInput.autocomplete = 'off';
    theInput.setAttribute('name', 'answer');
    theInput.setAttribute('value', '');
    thisElement.parentNode.insertBefore(theInput, thisElement.previousSibling);
}