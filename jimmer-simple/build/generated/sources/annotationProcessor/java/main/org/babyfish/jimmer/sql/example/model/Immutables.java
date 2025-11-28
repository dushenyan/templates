package org.babyfish.jimmer.sql.example.model;

import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.internal.GeneratedBy;

@GeneratedBy
public interface Immutables {
    static Author createAuthor(DraftConsumer<AuthorDraft> block) {
        return AuthorDraft.$.produce(block);
    }

    static Author createAuthor(Author base, DraftConsumer<AuthorDraft> block) {
        return AuthorDraft.$.produce(base, block);
    }

    static Book createBook(DraftConsumer<BookDraft> block) {
        return BookDraft.$.produce(block);
    }

    static Book createBook(Book base, DraftConsumer<BookDraft> block) {
        return BookDraft.$.produce(base, block);
    }

    static BookStore createBookStore(DraftConsumer<BookStoreDraft> block) {
        return BookStoreDraft.$.produce(block);
    }

    static BookStore createBookStore(BookStore base, DraftConsumer<BookStoreDraft> block) {
        return BookStoreDraft.$.produce(base, block);
    }

    static TreeNode createTreeNode(DraftConsumer<TreeNodeDraft> block) {
        return TreeNodeDraft.$.produce(block);
    }

    static TreeNode createTreeNode(TreeNode base, DraftConsumer<TreeNodeDraft> block) {
        return TreeNodeDraft.$.produce(base, block);
    }
}
