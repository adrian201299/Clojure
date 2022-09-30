;; Zadanie 1. - ciąg Fibonacciego

(def FibonaCC  
  ((fn fib [a b] 
     (lazy-seq (cons a (fib b (+ a b))))) 0 1)) 


(take 10 FibonaCC) 



;; Zadanie 2 - Metoda Heron'a

(defn abs- [x]
  (if (< x 0)
    (- x)
    x))

(defn square [x] (* x x))
(defn good-enough [G x Epsilon]
  (< (abs- (- x (square G))) Epsilon))

(defn avg [x y]
  (/ (+ x y) 2))

(defn improve [G x]
  (avg G (/ x G)))
(defn sqrt [G x Epsilon]
  (if (good-enough G x Epsilon)
    G
    (sqrt (improve G x) x Epsilon)))

(sqrt 1 2 0.00000001)

