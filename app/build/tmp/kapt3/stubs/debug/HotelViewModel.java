
/**
 * ViewModel for fetching hotel data from the Amadeus API.
 * This ViewModel handles network requests asynchronously, bypasses SSL certificate validation,
 * and updates UI components - Hotel name drop down spinner.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\t0\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"LHotelViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "hotels", "", "LHotel;", "fetchHotels", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadHotels", "", "onResult", "Lkotlin/Function1;", "parseHotels", "jsonStr", "", "app_debug"})
public final class HotelViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private java.util.List<Hotel> hotels;
    
    public HotelViewModel() {
        super();
    }
    
    /**
     * Fetch hotels asynchronously and handle the result on the UI thread.
     * @param onResult Callback to pass the fetched hotels back to the UI thread.
     */
    public final void loadHotels(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<Hotel>, kotlin.Unit> onResult) {
    }
    
    /**
     * Fetch hotels from the API.
     * @return List of Hotel objects parsed from the API response.
     */
    private final java.lang.Object fetchHotels(kotlin.coroutines.Continuation<? super java.util.List<Hotel>> $completion) {
        return null;
    }
    
    /**
     * Parse JSON response into a list of Hotel objects.
     * @param jsonStr JSON string to parse.
     * @return List of Hotel objects.
     */
    private final java.util.List<Hotel> parseHotels(java.lang.String jsonStr) {
        return null;
    }
}