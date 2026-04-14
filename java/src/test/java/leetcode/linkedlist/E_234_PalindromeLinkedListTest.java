package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class E_234_PalindromeLinkedListTest {
    private ListNode createList(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    @Test
    void testEmptyList() {
        E_234_PalindromeLinkedList pll = new E_234_PalindromeLinkedList();
        assertTrue(pll.isPalindrome(null));
    }

    @Test
    void testSingleElementList() {
        E_234_PalindromeLinkedList pll = new E_234_PalindromeLinkedList();
        assertTrue(pll.isPalindrome(createList(1)));
    }

    @Test
    void testTwoElementPalindrome() {
        E_234_PalindromeLinkedList pll = new E_234_PalindromeLinkedList();
        assertTrue(pll.isPalindrome(createList(1, 1)));
    }

    @Test
    void testTwoElementNonPalindrome() {
        E_234_PalindromeLinkedList pll = new E_234_PalindromeLinkedList();
        assertFalse(pll.isPalindrome(createList(1, 2)));
    }

    @Test
    void testOddLengthPalindrome() {
        E_234_PalindromeLinkedList pll = new E_234_PalindromeLinkedList();
        assertTrue(pll.isPalindrome(createList(1, 2, 1)));
    }

    @Test
    void testEvenLengthPalindrome() {
        E_234_PalindromeLinkedList pll = new E_234_PalindromeLinkedList();
        assertTrue(pll.isPalindrome(createList(1, 2, 2, 1)));
    }

    @Test
    void testNotPalindrome() {
        E_234_PalindromeLinkedList pll = new E_234_PalindromeLinkedList();
        assertFalse(pll.isPalindrome(createList(1, 2, 3, 2, 4)));
    }
}