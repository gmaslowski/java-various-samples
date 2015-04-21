angular.module("chatApp.controllers").controller("ChatCtrl", function($scope, ChatService) {
    $scope.messages = [];
    $scope.message = "";

    $scope.addMessage = function() {
        ChatService.send($scope.message);
        $scope.message = "";
    };

    ChatService.receive().then(null, null, function(message) {
        $scope.messages.push(message);
    });
});
