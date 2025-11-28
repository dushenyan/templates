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
import org.babyfish.jimmer.sql.fetcher.impl.FetcherImpl;
import org.babyfish.jimmer.sql.fetcher.spi.AbstractTypedFetcher;

@GeneratedBy(
        type = BookStore.class
)
public class BookStoreFetcher extends AbstractTypedFetcher<BookStore, BookStoreFetcher> {
    public static final BookStoreFetcher $ = new BookStoreFetcher(null);

    private BookStoreFetcher(FetcherImpl<BookStore> base) {
        super(BookStore.class, base);
    }

    private BookStoreFetcher(BookStoreFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private BookStoreFetcher(BookStoreFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static BookStoreFetcher $from(Fetcher<BookStore> base) {
        return base instanceof BookStoreFetcher ? 
        	(BookStoreFetcher)base : 
        	new BookStoreFetcher((FetcherImpl<BookStore>)base);
    }

    @NewChain
    public BookStoreFetcher name() {
        return add("name");
    }

    @NewChain
    public BookStoreFetcher name(boolean enabled) {
        return enabled ? add("name") : remove("name");
    }

    @NewChain
    public BookStoreFetcher website() {
        return add("website");
    }

    @NewChain
    public BookStoreFetcher website(boolean enabled) {
        return enabled ? add("website") : remove("website");
    }

    @NewChain
    public BookStoreFetcher books() {
        return add("books");
    }

    @NewChain
    public BookStoreFetcher books(boolean enabled) {
        return enabled ? add("books") : remove("books");
    }

    @NewChain
    public BookStoreFetcher books(Fetcher<Book> childFetcher) {
        return add("books", childFetcher);
    }

    @NewChain
    public BookStoreFetcher books(Fetcher<Book> childFetcher,
            Consumer<ListFieldConfig<Book, BookTable>> fieldConfig) {
        return add("books", childFetcher, fieldConfig);
    }

    @Override
    protected BookStoreFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new BookStoreFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected BookStoreFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new BookStoreFetcher(this, prop, fieldConfig);
    }
}
