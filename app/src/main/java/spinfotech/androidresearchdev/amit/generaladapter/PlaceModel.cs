using System;
using Square.OkIO;

namespace Motogari.Droid.Adapters
{ 
    public class PlaceModel : Java.IO.ISerializable
	{
		public PlaceModel()
		{
		}

		public string AttributedFullText { get; set; }

		public string PlaceID { get; set; }

		public string Latitude { get; set; }

		public string Longitude { get; set; }

        public IntPtr Handle => throw new NotImplementedException();

        public void Dispose()
        {
            throw new NotImplementedException();
        }
    }
}