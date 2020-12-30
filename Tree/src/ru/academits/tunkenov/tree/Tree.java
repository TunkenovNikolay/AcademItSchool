package ru.academits.tunkenov.tree;

import java.util.*;
import java.util.function.Consumer;

public class Tree<T> {
    private TreeNode<T> root;
    private int count;
    Comparator<T> comparator;

    public Tree() {
    }

    public Tree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public boolean find(T data) {
        TreeNode<T> currently = root;

        for (; ; ) {
            if (comparator.compare(data, currently.getData()) == 0) {
                return true;
            }
            if (comparator.compare(data, currently.getData()) < 0) {
                if (currently.getLeft() != null) {
                    currently = currently.getLeft();
                } else {
                    return false;
                }
            } else {
                if (currently.getRight() != null) {
                    currently = currently.getRight();
                } else {
                    return false;
                }
            }
        }
    }

    public void add(T data) {
        count++;

        if (root == null) {
            root = new TreeNode<>(data);
            return;
        }

        TreeNode<T> currently = root;
        TreeNode<T> newNode = new TreeNode<>(data);

        for (; ; ) {
            if (comparator.compare(newNode.getData(), currently.getData()) < 0) {
                if (currently.getLeft() != null) {
                    currently = currently.getLeft();
                } else {
                    currently.setLeft(newNode);
                    return;
                }
            } else {
                if (currently.getRight() != null) {
                    currently = currently.getRight();
                } else {
                    currently.setRight(newNode);
                    return;
                }
            }
        }
    }

    public boolean remove(T data) {
        TreeNode<T> previous = null;
        TreeNode<T> currently = root;
        boolean left = false;

        while (comparator.compare(data, currently.getData()) != 0) {
            if (comparator.compare(data, currently.getData()) < 0) {
                if (currently.getLeft() != null) {
                    previous = currently;
                    currently = currently.getLeft();
                    left = true;
                } else {
                    return false;
                }
            } else {
                if (currently.getRight() != null) {
                    previous = currently;
                    currently = currently.getRight();
                    left = false;
                } else {
                    return false;
                }
            }
        }

        count--;

        if (comparator.compare(root.getData(), data) == 0) {
            TreeNode<T> minimum = currently.getRight();
            TreeNode<T> previousMinimum = root;

            while (minimum.getLeft() != null) {
                previousMinimum = minimum;
                minimum = minimum.getLeft();
            }

            if (minimum.getRight() == null) {
                previousMinimum.setLeft(null);
                if (left) {
                    previous.setLeft(minimum);
                    return true;
                }

                previous.setRight(minimum);
                return true;
            }

            if (left) {
                previousMinimum.setLeft(minimum.getRight());
                previous.setLeft(minimum);
                return true;
            }

            previousMinimum.setLeft(minimum.getRight());
            previous.setRight(minimum);

            return true;
        }

        if (currently.getLeft() == null && currently.getRight() == null) {
            if (left) {
                previous.setLeft(null);
                return true;
            }

            previous.setRight(null);
            return true;

        }

        if (currently.getLeft() != null && currently.getRight() == null) {
            if (left) {
                previous.setLeft(currently.getLeft());
                return true;
            }

            previous.setRight(currently.getLeft());
            return true;

        }
        if (currently.getLeft() == null && currently.getRight() != null) {
            if (left) {
                previous.setLeft(currently.getRight());
                return true;
            }

            previous.setRight(currently.getRight());
            return true;
        }

        TreeNode<T> minimum = currently.getRight();
        TreeNode<T> previousMinimum = root;

        while (minimum.getLeft() != null) {
            previousMinimum = minimum;
            minimum = minimum.getLeft();
        }

        if (minimum.getRight() == null) {
            previousMinimum.setLeft(null);
            if (left) {
                previous.setLeft(minimum);
                return true;
            }

            previous.setRight(minimum);
            return true;
        }

        if (left) {
            previousMinimum.setLeft(minimum.getRight());
            previous.setLeft(minimum);
            return true;
        }

        previousMinimum.setLeft(minimum.getRight());
        previous.setRight(minimum);

        return true;
    }

    public int getCount() {
        return count;
    }

    public void BFS(Consumer<T> consumer) {
        Queue<TreeNode<T>> queue = new PriorityQueue<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            consumer.accept(queue.element().getData());
            if (queue.element().getLeft() != null) {
                queue.add(root.getLeft());
            }
            if (queue.element().getRight() != null) {
                queue.add(root.getRight());
            }

            queue.remove();
        }
    }
}
