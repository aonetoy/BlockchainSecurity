pragma solidity^0.4.18;

contract ShortAddress {
    address owner = msg.sender;
    uint c=3;

    function transfer(address _to, uint amount) public {
       
    }
    function test() public {
	transfer(owner, c);
    }
}

contract ErroneousConstructorName{
    
    function erroneousconstructorname() {
        
    }
    
}

contract TimestampDependence {
    uint startTime;
    address coinBase;

    function start() internal {
	startTime = block.timestamp;
	coinBase = block.coinbase;
    }
}