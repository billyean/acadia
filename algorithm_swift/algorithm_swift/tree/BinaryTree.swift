//
//  BinaryTree.swift
//  algorithm_swift
//
//  Created by Haibo Yan on 3/26/18.
//  Copyright © 2018 Haibo Yan. All rights reserved.
//

import Foundation

class BinaryTreeNode<Element> {
    var left: BinaryTreeNode<Element>?
    
    var right: BinaryTreeNode<Element>?
    
    var e: Element
    
    init(_ by: Element) {
        self.e = by
    }
}

class BinaryTree<Element> {
    var root : BinaryTreeNode<Element>?
    
    init(_ by: BinaryTreeNode<Element>?) {
        root = by
    }
    
    func prevOrderTraverse() -> [Element] {
        var ordered = [Element]()
        
        var stack = [BinaryTreeNode<Element>]()
        
        if let root = root {
            stack.append(root)
            
            while stack.count != 0 {
                let top = stack.removeLast()
                ordered.append(top.e)
                if let right = top.right {
                    stack.append(right)
                }
                if let left = top.left {
                    stack.append(left)
                }
            }
        }
        
        return ordered
    }
    
    func inOrderTraverse() -> [Element] {
        var ordered = [Element]()
        var stack = [BinaryTreeNode<Element>]()
        
        if let root = root {
            var current: BinaryTreeNode<Element>? = root
            
            while stack.count != 0 || current != nil {
                if let c = current {
                    stack.append(c)
                    current = c.left
                } else {
                    current = stack.removeLast()
                    ordered.append(current!.e)
                    current = current?.right
                }
            }
        }
        
        return ordered
    }
    
    func postOrderTraverse() -> [Element] {
        var ordered = [Element]()

        if let root = root {
            var stack = [BinaryTreeNode<Element>]()
            stack.append(root)
            var prev: BinaryTreeNode<Element>? = nil

            while stack.count != 0 {
                let current = stack.last

                if prev === nil || prev!.left === current || prev!.right === current {
                    if let left = current?.left {
                        stack.append(left)
                    } else if let right = current?.right {
                        stack.append(right)
                    } else {
                        ordered.append((current?.e)!)
                        stack.removeLast()
                    }
                } else if let prev = prev {
                    if prev === current?.left {
                        if let right = current?.right {
                            stack.append(right)
                        } else {
                            stack.removeLast()
                            ordered.append((current?.e)!)
                        }
                    } else {
                        stack.removeLast()
                        ordered.append((current?.e)!)
                    }
                }
                prev = current
            }

        }
        return ordered
    }
}

