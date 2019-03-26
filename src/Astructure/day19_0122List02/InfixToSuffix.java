package Astructure.day19_0122List02;

/**
 *  利用栈实现中缀表达式转后缀表达式
 */
public class InfixToSuffix {

    public static void main(String[] args) {

        InfixToSuffix its = new InfixToSuffix();
        // 中缀表达式
        String infix = "9+(3-1)*3+10/2";

        // 中缀转后缀 "9 3 1 - 3 * 10 2 / + +"
        its.infixToSuffix(infix);

    }

    /**
     *  中缀转后缀算法
     *      1、运算符入栈，数字入队
     *      2、匹配到双 “()” 时，出栈 “()” 中的运算符
     *      3、栈顶优先级低出栈
     *      4、*、/ 号先入栈，待后一位数字入队后再直接出栈
     *      5、若中缀表达式已入栈入队完毕，则陆续把栈中的运算符出栈然后入队
     * @param infix
     * @return
     */
    public String infixToSuffix(String infix){
        // 创建一个栈
        Stack<Character> stack = new ArrayStack<>();
        // 创建一个队列
        Queue<String> queue = new ArrayQueue<>();
        // 中缀表达式转后缀表达式
        int start = 0;
        int end = 0;
        String x = "";
        // substring(int start, int end);  end >   >= start
        for(int i = 0; i < infix.length(); i ++){
            char c = infix.charAt(i);
            // '*' '/' 待后一位数字入队后入队
            if(!stack.isEmpty() && (stack.getTop().equals('*') || stack.getTop().equals('/'))){
                x = stack.pop() + "";
            }
            int s1 = ((ArrayStack<Character>) stack).size; // '*' '/' 入队标志 1
            switch (c){
                // '+' '-' 直接入栈 , 前面的数字入队
                case '+' : stack.push(c);  queue.push(infix.substring(start,end)); start = ++end; break;
                case '-' : stack.push(c);  queue.push(infix.substring(start,end)); start = ++end; break;
                // '*' '/' 符号入栈，数字入队后 符号出栈跟着入队
                case '*' : stack.push(c);  queue.push(infix.substring(start,end)); start = ++end; break;
                case '/' : stack.push(c);  queue.push(infix.substring(start,end)); start = ++end; break;
                // '(' 入栈 ')' 入栈并匹配 '(' ，出栈 '()' 间的运算符并入队
                case '(' : stack.push(c);  queue.push(infix.substring(start,end)); start = ++end; break;
                case ')' : stack.push(c);  queue.push(infix.substring(start,end));
                            while (true){
                                Character pop = stack.pop();
                                if(pop.equals('(')){
                                    start = ++end; break;
                                }else if(!pop.equals(')')){
                                    queue.push(pop + "");
                                }
                            } break;
                default: end++; break;
            }
            int s2 = ((ArrayStack<Character>) stack).size; // '*' '/' 入队标志 2
            if(s1 != s2){ // 当标志位不等时表示  '*' '/' 的后一位数字已入队
                queue.push(x);
                x = "";
            }
        }
        queue.push(infix.substring(start,end)); // 将最后一位运算符之后的数字入队
        queue.push(x); // 若'*' '/' 之后无其他运算符，则把最后一位 入队
        // 栈中的还未出栈符号全部出栈
        int size =  ((ArrayStack<Character>) stack).size;
        for(int s = 0; s < size; s ++){
            queue.push(stack.pop() + "");
        }
        // 打印后缀表达式
        size = ((ArrayQueue<String>) queue).size;
        StringBuilder suffix = new StringBuilder();
        Queue<String> newQueue = new ArrayQueue();
        for(int i = 0; i < size; i ++){
            String c = queue.pop();
            if(!c.equals("")){
                System.out.print(c + " ");
                suffix.append(c);
                newQueue.push(c);
            }
        }
        // 计算后缀表达式的值
        int calc = calc(newQueue, ((ArrayQueue<String>) newQueue).size);
        System.out.println("计算后缀表达式的值 = " + calc);
        return suffix + "";
    }

    /**
     *  计算后缀表达式的值
     * @param queue 中缀表达式队列
     * @param size 中缀表达式队列的长度
     * @return
     */
    public int calc(Queue<String> queue,int size){
        if(size == 1){
            return Integer.parseInt(queue.pop());
        }
        Queue<String> newQueue = new ArrayQueue();
        int f1 = Integer.parseInt(queue.pop());
        int f2 = Integer.parseInt(queue.pop());
        String f;
        boolean flag = true;
        for(int i = 2; i < size; i++){
            f =  queue.pop();
            if(flag){
                switch (f){
                    // 匹配到运算符直接运算，否则给相应数字赋值
                    case "+" :  f = (f1 + f2) + ""; newQueue.push(f); flag = false; break;
                    case "-" :  f = (f1 - f2) + ""; newQueue.push(f); flag = false; break;
                    case "*" :  f = (f1 * f2) + ""; newQueue.push(f); flag = false; break;
                    case "/" :  f = (f1 / f2) + ""; newQueue.push(f); flag = false; break;
                    default: newQueue.push(f1 + ""); // 入队不用计算的数字
                        // 赋值出队的数字
                        f1 = f2;
                        f2 = Integer.parseInt(f);
                }
            }else {
                newQueue.push(f);
            }
        }
        return calc(newQueue,((ArrayQueue<String>) newQueue).size);
    }
}
