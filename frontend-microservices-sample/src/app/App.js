import React from "react";
import { Provider } from "react-redux";
import { BrowserRouter } from "react-router-dom";
import { LayoutSplashScreen, MaterialThemeProvider } from "../_metronic/layout";
import { I18nProvider } from "../_metronic/i18n";
import Routed from "./Routed";


function App({ store, persistor, basename }) {
  return (
    <Provider store={store}>
        {/* Add high level `Suspense` in case if was not handled inside the React tree. */}
        <React.Suspense fallback={<LayoutSplashScreen />}>
          {/* Override `basename` (e.g: `homepage` in `package.json`) */}
          <BrowserRouter basename={basename}>
            {/*This library only returns the location that has been active before the recent location change in the current window lifetime.*/}
            <MaterialThemeProvider>
              {/* Provide `react-intl` context synchronized with Redux state.  */}
              <I18nProvider>
                {/* Render routes with provided `Layout`. */}
                <Routed />
              </I18nProvider>
            </MaterialThemeProvider>
          </BrowserRouter>
        </React.Suspense>
    </Provider>
  );
}

export default App;
