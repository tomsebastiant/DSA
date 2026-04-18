package problems.linkedlist;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class E_PalindromeLinkedListTest {
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
        E_PalindromeLinkedList pll = new E_PalindromeLinkedList();
        assertTrue(pll.isPalindrome(null));
    }

    @Test
    void testSingleElementList() {
        E_PalindromeLinkedList pll = new E_PalindromeLinkedList();
        assertTrue(pll.isPalindrome(createList(1)));
    }

    @Test
    void testTwoElementPalindrome() {
        E_PalindromeLinkedList pll = new E_PalindromeLinkedList();
        assertTrue(pll.isPalindrome(createList(1, 1)));
    }

    @Test
    void testTwoElementNonPalindrome() {
        E_PalindromeLinkedList pll = new E_PalindromeLinkedList();
        assertFalse(pll.isPalindrome(createList(1, 2)));
    }

    @Test
    void testOddLengthPalindrome() {
        E_PalindromeLinkedList pll = new E_PalindromeLinkedList();
        assertTrue(pll.isPalindrome(createList(1, 2, 1)));
    }

    @Test
    void testEvenLengthPalindrome() {
        E_PalindromeLinkedList pll = new E_PalindromeLinkedList();
        assertTrue(pll.isPalindrome(createList(1, 2, 2, 1)));
    }

    @Test
    void testNotPalindrome() {
        E_PalindromeLinkedList pll = new E_PalindromeLinkedList();
        assertFalse(pll.isPalindrome(createList(1, 2, 3, 2, 4)));
    }
}



