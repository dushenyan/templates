package org.babyfish.jimmer.sql.example.model;

import java.lang.Override;
import java.util.function.Consumer;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.lang.NewChain;
import org.babyfish.jimmer.meta.ImmutableProp;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.babyfish.jimmer.sql.fetcher.FieldConfig;
import org.babyfish.jimmer.sql.fetcher.IdOnlyFetchType;
import org.babyfish.jimmer.sql.fetcher.ListFieldConfig;
import org.babyfish.jimmer.sql.fetcher.ReferenceFetchType;
import org.babyfish.jimmer.sql.fetcher.ReferenceFieldConfig;
import org.babyfish.jimmer.sql.fetcher.impl.FetcherImpl;
import org.babyfish.jimmer.sql.fetcher.spi.AbstractTypedFetcher;

@GeneratedBy(
        type = Book.class
)
public class BookFetcher extends AbstractTypedFetcher<Book, BookFetcher> {
    public static final BookFetcher $ = new BookFetcher(null);

    private BookFetcher(FetcherImpl<Book> base) {
        super(Book.class, base);
    }

    private BookFetcher(BookFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private BookFetcher(BookFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static BookFetcher $from(Fetcher<Book> base) {
        return base instanceof BookFetcher ? 
        	(BookFetcher)base : 
        	new BookFetcher((FetcherImpl<Book>)base);
    }

    @NewChain
    public BookFetcher name() {
        return add("name");
    }

    @NewChain
    public BookFetcher name(boolean enabled) {
        return enabled ? add("name") : remove("name");
    }

    @NewChain
    public BookFetcher edition() {
        return add("edition");
    }

    @NewChain
    public BookFetcher edition(boolean enabled) {
        return enabled ? add("edition") : remove("edition");
    }

    @NewChain
    public BookFetcher price() {
        return add("price");
    }

    @NewChain
    public BookFetcher price(boolean enabled) {
        return enabled ? add("price") : remove("price");
    }

    @NewChain
    public BookFetcher store() {
        return add("store");
    }

    @NewChain
    public BookFetcher store(boolean enabled) {
        return enabled ? add("store") : remove("store");
    }

    @NewChain
    public BookFetcher store(Fetcher<BookStore> childFetcher) {
        return add("store", childFetcher);
    }

    @NewChain
    public BookFetcher store(IdOnlyFetchType idOnlyFetchType) {
        return add("store", idOnlyFetchType);
    }

    @NewChain
    public BookFetcher store(Fetcher<BookStore> childFetcher,
            Consumer<ReferenceFieldConfig<BookStore, BookStoreTable>> fieldConfig) {
        return add("store", childFetcher, fieldConfig);
    }

    @NewChain
    public BookFetcher store(ReferenceFetchType fetchType, Fetcher<BookStore> childFetcher) {
        return store(childFetcher, cfg -> cfg.fetchType(fetchType));
    }

    @NewChain
    public BookFetcher authors() {
        return add("authors");
    }

    @NewChain
    public BookFetcher authors(boolean enabled) {
        return enabled ? add("authors") : remove("authors");
    }

    @NewChain
    public BookFetcher authors(Fetcher<Author> childFetcher) {
        return add("authors", childFetcher);
    }

    @NewChain
    public BookFetcher authors(Fetcher<Author> childFetcher,
            Consumer<ListFieldConfig<Author, AuthorTable>> fieldConfig) {
        return add("authors", childFetcher, fieldConfig);
    }

    @Override
    protected BookFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new BookFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected BookFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new BookFetcher(this, prop, fieldConfig);
    }
}
