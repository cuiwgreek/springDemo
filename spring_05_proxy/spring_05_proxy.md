代理模式:客户端直接使用的都是代理对象，不知道真实对象是谁，此时代理对象可以在客户端和真实对象之间起到中介的作用。
1、代理对象完全包含真实对象，客户端使用的都是代理对象的方法，和真实对象没有直接关系；
2、代理模式的职责: 把不是真实对象该做的事情从真实对象上撇开--职责清晰;

静态代理: 在程序运行前就已经存在代理类的字节码文件，代理对象和真实对象的关系在运行钱就确定好了。

特点:
优点:
1.业务类只需要关注业务逻辑本身，保证了业务类的重用性。
2.把真实对象隐藏起来了，保护真实对象。
缺点:
1.代理对象的某个接口只服务于某一类型的对象，也就是说的每一个真实对象都得创建一个代理对象。
2.如果需要代理的方法很多，则要为每一种方法都进行代理处理。
3.如果接口增加一个方法，除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。
